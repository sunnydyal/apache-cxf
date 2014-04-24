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

import java.io.IOException;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import com.insonix.cxf.impl.PersonServiceImpl;
/**
 * Stand-alone SOAP server
 * @author sunnydyal
 *
 */
public class ServiceStarter {
  private static Server server;
  public static final String ADDRESS = "http://localhost:9000/person";
  public static void main(String[] args) throws IOException {
    ServiceStarter.startSoapServer();
    System.in.read();

  }
  public static void startSoapServer() {
    PersonServiceImpl personService = new PersonServiceImpl();
    JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
    svrFactory.setServiceClass(PersonService.class);
    svrFactory.setAddress(ADDRESS);
    svrFactory.setServiceBean(personService);
    svrFactory.getInInterceptors().add(new LoggingInInterceptor());
    svrFactory.getOutInterceptors().add(new LoggingOutInterceptor());
    server = svrFactory.create();
    server.start();
  }
  
  public static void stopSoapServer() {
    server.stop();
  }

}
