package other.service_locator;

import java.util.ArrayList;
import java.util.List;

public class ServiceLocatorMain {

	public static void main(String[] args) {
		Service service = ServiceLocator.getService("Service1");
		service.execute();
		service = ServiceLocator.getService("Service2");
		service.execute();
		service.execute();
	}

}

interface Service {

	String getName();

	void execute();

}

class Service1 implements Service {

	@Override
	public String getName() {
		return "Service1";
	}

	@Override
	public void execute() {
		System.out.println("Executing Service1");
	}

}

class Service2 implements Service {

	@Override
	public String getName() {
		return "Service2";
	}

	@Override
	public void execute() {
		System.out.println("Executing Service2");
	}

}

class InitialContext {
	
	public Object lookup(String jndiName) {
		if (jndiName.equalsIgnoreCase("service1")) {
			return new Service1();
		} else if (jndiName.equalsIgnoreCase("service2")) {
			return new Service2();
		}
		else {
			throw new RuntimeException("No such jndiName found");
		}
	}
	
}

class Cache {
	
	private List<Service> services = new ArrayList<Service>();
	
	public Service getService(String serviceName) {
		for (Service service : services) {
			if (service.getName().equalsIgnoreCase(serviceName)) {
				System.out.println("Returning cached " + serviceName + " object");
				return service;
			}
		}
		return new Service() {			
			@Override
			public String getName() {				
				return "null";
			}			
			@Override
			public void execute() {
				
			}
		};
	}
	
	public void addService(Service newService) {
		boolean isExists = false;
		for (Service service : services) {
			if (service.getName().equalsIgnoreCase(newService.getName())) {
				isExists = true;
			}
		}
		if (!isExists) {
			services.add(newService);
		}
	}
	
}

class ServiceLocator {
	
	private static Cache cache = new Cache();
	
	public static Service getService(String jndiName) {
		Service serviceFromCache = cache.getService(jndiName);
		if (!serviceFromCache.getName().equals("null")) {
			return serviceFromCache;
		}
		InitialContext context = new InitialContext();
		Service serviceFromContext = (Service) context.lookup(jndiName);
		cache.addService(serviceFromContext);
		System.out.println("New service created, name : " + serviceFromContext.getName());
		return serviceFromContext;
	}
	
}




//
//

//
//