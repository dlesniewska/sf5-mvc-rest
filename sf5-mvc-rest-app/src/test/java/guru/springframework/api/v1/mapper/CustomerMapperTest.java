package guru.springframework.api.v1.mapper;

import guru.springframework.domain.Customer;
import guru.springframework.model.CustomerDTO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerMapperTest {

    public static final String FIRSTNAME = "Joe";
    public static final String LASTNAME = "Buck";
    public static final long ID = 1L;

    CustomerMapper customeryMapper = CustomerMapper.INSTANCE;

    @Test
    public void testCustomerToCustomerDTO() throws Exception {

        //given
        Customer customer = new Customer();
        customer.setFirstname(FIRSTNAME);
        customer.setLastname(LASTNAME);
        customer.setId(ID);

        //when
        CustomerDTO customerDTO = customeryMapper.customerToCustomerDTO(customer);

        //then
        assertEquals(Long.valueOf(ID), customerDTO.getId());
        assertEquals(FIRSTNAME, customerDTO.getFirstname());
        assertEquals(LASTNAME, customerDTO.getLastname());
    }

    @Test
    public void testCustomerDTOToCustomer() throws Exception {

        //given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstname(FIRSTNAME);
        customerDTO.setLastname(LASTNAME);
        customerDTO.setId(ID);

        //when
        Customer customer = customeryMapper.customerDTOToCustomer(customerDTO);

        //then
        assertEquals(Long.valueOf(ID), customer.getId());
        assertEquals(FIRSTNAME, customer.getFirstname());
        assertEquals(LASTNAME, customer.getLastname());
    }

}