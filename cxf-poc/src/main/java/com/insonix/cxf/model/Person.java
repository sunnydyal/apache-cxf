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
package com.insonix.cxf.model;

import javax.xml.bind.annotation.XmlRootElement;
/** 
 * Entity bean for person
 * @author sunnydyal
 *
 */
@XmlRootElement
public class Person {
  private Integer id;
  
  private String name;
  
  private String phone;

  public Person() {
  }

  public Person(Integer id, String name, String phone) {
    super();
    this.id = id;
    this.name = name;
    this.phone = phone;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPhone() {
    return phone;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Person(String name, String phone) {
    this.name = name;
    this.phone = phone;
  }
  
  
}
