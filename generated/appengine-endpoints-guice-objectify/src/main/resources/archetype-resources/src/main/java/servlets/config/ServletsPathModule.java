#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.servlets.config;

import ${package}.servlets.HomeServlet;

import com.google.inject.servlet.ServletModule;
import com.googlecode.objectify.ObjectifyFilter;

/**
 * This starts in web.xml. All requests are intercepted and sent here.
 * 
 * http://localhost:8888/_ah/admin - Goto the App Engine Dashboard.
 * http://localhost:8888/_ah/api/systemuserendpoint/v1/systemuser - list system users.
 * http://localhost:8888/_ah/api/todoendpoint/v1/todo - list todos.
 */
public class ServletsPathModule extends ServletModule {

  @Override
  public void configureServlets() {
    super.configureServlets();

    // ignore _ah (http://localhost:8888/_ah/*)
    serveRegex("^/(?!_ah.*)home").with(HomeServlet.class);
    
    filter("/*").through(ObjectifyFilter.class);
  }

}
