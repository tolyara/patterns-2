package other.intercepting_filter;

import java.util.ArrayList;
import java.util.List;

public class InterceptingFilterMain {

	public static void main(String[] args) {
		FilterManager filterManager = new FilterManager();
		filterManager.setFilter(new AuthFilter());
		filterManager.setFilter(new IPFilter());
		filterManager.filterRequest("Home");
	}

}

interface Filter {

	void execute(String data);

}

class AuthFilter implements Filter {

	@Override
	public void execute(String data) {
		System.out.println("Auth filter data...");
	}

}

class IPFilter implements Filter {

	@Override
	public void execute(String data) {
		System.out.println("IP filter data...");
	}

}

class FilterChain {
	
	List<Filter> filterList = new ArrayList<Filter>();
	Target target = new Target();
	
	void addFilter(Filter filter) {
		filterList.add(filter);
	}
	
	void filter(String data) {
		for (Filter filter : filterList) {
			filter.execute(data);
		}
		target.doJob(data);
	}
	
}

class FilterManager {
	
	FilterChain filterChain = new FilterChain();
	
	void setFilter(Filter filter) {
		filterChain.addFilter(filter);
	}
	
	void filterRequest(String request) {
		filterChain.filter(request);
	}
	
}

class Target {

	void doJob(String data) {
		System.out.println("Data that came in : " + data);
	}

}

//
//
//
//
//
//