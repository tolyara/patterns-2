package other.business_delegate;

public class BusinessDelegateMain {

	public static void main(String[] args) {
		BusinessDelegate businessDelegate = new BusinessDelegate();
		businessDelegate.doTask("EJB///");
	}

}

interface BusinessService {

	void doJob();

}

class EJBService implements BusinessService {

	@Override
	public void doJob() {
		System.out.println("Do EJB job...");
	}

}

class JMSService implements BusinessService {

	@Override
	public void doJob() {
		System.out.println("Do JMS job...");
	}

}

class LookupService {

	BusinessService getService(String serviceType) {
		if (serviceType.equals("EJB")) {
			return new EJBService();
		} else if (serviceType.equals("JMS")) {
			return new JMSService();
		} else {
			throw new RuntimeException("No such service type found");
		}
	}

}

class BusinessDelegate {

	LookupService lookupService = new LookupService();
	BusinessService businessService;

	void doTask(String serviceType) {
		businessService = lookupService.getService(serviceType);
		businessService.doJob();
	}

}

//