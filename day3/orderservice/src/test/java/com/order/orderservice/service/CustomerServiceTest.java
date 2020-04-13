package com.order.orderservice.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class CustomerServiceTest {

	@Mock
	private CustomerDao daoMock;

	@InjectMocks
	private CustomerService service;

	@Captor
	private ArgumentCaptor<Customer> customerArgument;

	public CustomerServiceTest() {

		MockitoAnnotations.initMocks(this);
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void whenCreateSpy_thenCreate() {
	    List spyList = Mockito.spy(new ArrayList());
	    spyList.add("one");
	    Mockito.verify(spyList,times(1)).add("one");
	    assertEquals(1, spyList.size());
	}
	
	@Test
	public void whenCreateMock_thenCreated() {
	    @SuppressWarnings("rawtypes")
		List mockedList = (ArrayList) Mockito.mock(ArrayList.class);

	    mockedList.add("one");
	    Mockito.verify(mockedList).add("one");

	    assertEquals(0, mockedList.size());
	}
	@Test
	public void test() {
		Customer customer = new Customer();
		when(daoMock.save(any(Customer.class))).thenReturn(customer);
		assertThat(service.addCustomer(customer), is(customer));
		verify(daoMock).save(any(Customer.class));
		verify(daoMock, times(1)).save(any(Customer.class));

	}


	@Test
	public void testRegister() {

		// Requirement: we want to register a new customer. Every new customer
		// should be assigned a random token before saving in the database.
		service.register(new Customer());

		// captures the argument which was passed in to save method.
		verify(daoMock).save(customerArgument.capture());

		// make sure a token is assigned by the register method before saving.
		assertThat(customerArgument.getValue().getToken(), is(notNullValue()));

	}

	@Test
	public void testAddCustomer_returnsNewCustomer() {

		when(daoMock.save(any(Customer.class))).thenReturn(new Customer());

		Customer customer = new Customer();

		assertThat(service.addCustomer(customer), is(notNullValue()));

	}

	@Test
	public void testAddCustomer_returnsNewCustomerWithId() {

		when(daoMock.save(any(Customer.class))).thenAnswer(new Answer<Customer>() {

			@Override
			public Customer answer(InvocationOnMock invocation) throws Throwable {

				Object[] arguments = invocation.getArguments();

				if (arguments != null && arguments.length > 0 && arguments[0] != null) {

					Customer customer = (Customer) arguments[0];
					customer.setId(1);

					return customer;
				}

				return null;
			}
		});

		Customer customer = new Customer();

		assertThat(service.addCustomer(customer), is(notNullValue()));

	}

	@Test
	public void testAddCustomer_throwsException() {

		when(daoMock.save(any(Customer.class))).thenThrow(RuntimeException.class);

		Customer customer = new Customer();

		assertThat(service.addCustomer(customer), is(nullValue()));

	}

	@Test
	public void testUpdate() {

		doAnswer(new Answer<Void>() {

			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				Object[] arguments = invocation.getArguments();
				if (arguments != null && arguments.length > 1 && arguments[0] != null && arguments[1] != null) {

					Customer customer = (Customer) arguments[0];
					String email = (String) arguments[1];
					customer.setEmail(email);

				}
				return null;
			}
		}).when(daoMock).updateEmail(any(Customer.class), any(String.class));

		// calling the method under test
		Customer customer = service.changeEmail("old@test.com", "new@test.com");

		assertThat(customer, is(notNullValue()));
		assertThat(customer.getEmail(), is(equalTo("new@test.com")));

	}

	@Test(expected = RuntimeException.class)
	public void testUpdate_throwsException() {

		doThrow(RuntimeException.class).when(daoMock).updateEmail(any(Customer.class), any(String.class));

		// calling the method under test
		Customer customer = service.changeEmail("old@test.com", "new@test.com");

	}
	
	
}
