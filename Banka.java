import java.util.ArrayList;

public class Banka {

	private ArrayList<Hesap> hesaplar = new ArrayList<>();

	public void hesap_ekle(Hesap eklencek_hesap) {

		hesaplar.add(eklencek_hesap);

	}

	public Hesap login(String iban, String password) {

		for (Hesap hesap : hesaplar) {

			if (hesap.getIban().equals(iban) && hesap.sifre_kontrol(password)) {
				return hesap; 


			}

		}
		return null;

	}

	public Hesap hesap_bul(String iban) {

		for (Hesap hesap : hesaplar) {
			if (hesap.getIban().equals(iban)) {
				return hesap;

			}

		}
		return null;

	}
	public boolean iban_kontrol(String iban) {
		
      for (Hesap hesap : hesaplar) {
    	  
    	  if (hesap.getIban().equals(iban)) {
    		  return true;
			
		}
    	  
		
	}
      return false;
		
	}

}
