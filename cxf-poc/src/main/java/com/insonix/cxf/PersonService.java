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

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.insonix.cxf.model.Person;

/**
 * SOAP - Web service for person
 * 
 * @author sunnydyal
 *
 */
@WebService
public interface PersonService {
  /**
   * Get all person.
   * 
   * @return List
   */
  @WebMethod
  List<Person> getAll();

  /**
   * Get a person by id
   * 
   * @param personId
   * @return
   */
  @WebMethod
  Person getPerson(@WebParam Integer personId);

  /**
   * Add a new person
   * 
   * @param person
   */
  @WebMethod
  void addPerson(@WebParam Person person);
}
