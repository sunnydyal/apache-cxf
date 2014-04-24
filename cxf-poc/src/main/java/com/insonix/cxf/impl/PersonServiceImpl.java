package com.insonix.cxf.impl;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import com.insonix.cxf.PersonService;
import com.insonix.cxf.model.Person;
/**
 * Person service implementation
 * @author sunnydyal
 *
 */
@WebService(endpointInterface = "com.insonix.cxf.PersonService", serviceName = "PersonService")
public class PersonServiceImpl implements PersonService {
  Map<String, Person> moPerson;

  public PersonServiceImpl() {
    moPerson = new HashMap<String, Person>();
    moPerson.put("1", new Person(1, "Sunny Dyal", "+919815894018"));
    moPerson.put("2", new Person(2, "Sony John", "+919715894017"));
    moPerson.put("3", new Person(3, "Ajeet Boparai", "+919615894016"));
    moPerson.put("4", new Person(4, "Bean Pole", "+919515894015"));
    moPerson.put("5", new Person(5, "Steve Arora", "+919415894014"));
    
  }

  @Override
  public List<Person> getAll() {
    return new ArrayList<Person>(moPerson.values());
  }

  @Override
  public Person getPerson(Integer personId) {
    return moPerson.get(personId+"");
  }

  @Override
  public void addPerson(Person person) {
    if(person!=null) {
      int id = moPerson.size()+1;
      person.setId(id);
      moPerson.put(id+"", person);
    }
  }
  
  
}
