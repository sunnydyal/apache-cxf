package com.insonix.cxf.client;
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
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.insonix.cxf.PersonService;
import com.insonix.cxf.model.Person;
/**
 * Client proxy
 * @author sunnydyal
 *
 */
public final class PersonServiceClient {
  
  private PersonServiceClient() { }
  @SuppressWarnings("resource")
  public static void main(String args[]) throws Exception {
      ClassPathXmlApplicationContext context 
         = new ClassPathXmlApplicationContext(
            new String[]{"cxf-servlet.xml"});

      PersonService personService = (PersonService)context.getBean("personClient");
      
      Person person = personService.getPerson(1);
      System.out.println("Response: " + person.getName());
      System.exit(0);
  }
}