package structural.proxy;

public class ProxyMain {

	public static void main(String[] args) {
		Internet cable = new InternetCable();
		cable.shareInternet();
		
		System.out.println();
		
		Internet router = new WifiRouter();
		router.shareInternet();
	}
	
}

interface Internet {
	
	void shareInternet();
	
}

class WifiRouter implements Internet {
	
	Internet internetCable = new InternetCable();

	void giveoutWifiOnLaptop() {
		System.out.println("Sharing internet by Wi-Fi to Laptop...");
	}
	
	void giveoutWifiOnSmartphone() {
		System.out.println("Sharing internet by Wi-Fi to smartphone...");
	}
	
	@Override
	public void shareInternet() {
		internetCable.shareInternet();
		giveoutWifiOnLaptop();
		giveoutWifiOnSmartphone();
	}
	
}

class InternetCable implements Internet {

	@Override
	public void shareInternet() {
		System.out.println("Sharing internet by the cable to PC...");
	}
	
}