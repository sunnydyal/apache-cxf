/**
 * Copyright © 2014 Insonix !
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of these CXF
 * Experiments and associated documentation files (the “Software”), to deal in the Software without
 * restriction, including without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.insonix.cxf;

import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import com.insonix.cxf.model.Person;
/**
 * Junit test class for person service
 * @author sunnydyal
 *
 */
public class PersonServiceTest {
  private static JaxWsProxyFactoryBean factory;
  private static PersonService personService;
  
  @BeforeClass
  public static void startSoapServer() {
    ServiceStarter.startSoapServer();
    factory = new JaxWsProxyFactoryBean();
    factory.getInInterceptors().add(new LoggingInInterceptor());
    factory.getOutInterceptors().add(new LoggingOutInterceptor());
    factory.setServiceClass(PersonService.class);
    factory.setAddress(ServiceStarter.ADDRESS);
    personService = (PersonService) factory.create();
  }
  @Test
  public void testGetAll() {
    List<Person> aoPerson = personService.getAll();
    System.out.println("Total Persons : " + aoPerson.size());
    for(Person person:aoPerson) {
      System.out.println(person.getName());
    }
    
  }
  
  @Test
  public void testGetPerson() {
    Person person = personService.getPerson(4);
    Assert.assertNotNull(person);
    System.out.println("Person Name : " + person.getName());
    
  }
  
  @Test
  public void testAddPerson() {
    Person person = new Person("New Person","New Phone");
    personService.addPerson(person);
    List<Person> aoPerson = personService.getAll();
    System.out.println("Total Persons : " + aoPerson.size());
    
  }
  @AfterClass
  public static void stopSoapServer() {
    ServiceStarter.stopSoapServer();
  }
  
}
