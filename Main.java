
import java.util.Scanner;



public class Main {

	static Scanner sc = new Scanner(System.in);
	static Banka banka = new Banka();

	public static void main(String[] args) {

		while (true) {

			System.out.println("\n--- ANA MENÜ ---");
			System.out.println("1- Giriş Yap");
			System.out.println("2- Hesap Oluştur");
			System.out.println("0- Çıkış");

			int secim = guvenli_int("Seçim : ");

			switch (secim) {

			case 1:
				loginekranı();
				break;

			case 2:
				hesap_olustur();
				break;

			case 0:
				System.out.println("Programdan cıkılıyor..");
				return;

			default:
				System.out.println("Geçersiz seçim!");
			}

		}

	}

	public static int guvenli_int(String mesaj) {

		while (true) {
			System.out.println(mesaj);
			String input = sc.nextLine();

			try {
				return Integer.parseInt(input);

			} catch (Exception e) {
				System.out.println("Hatalı tuslama(girdi) yaptınız , tekrar deneyiniz.");

			}

		}
	}

	public static void loginekranı() {

		int deneme = 0;

		while (deneme < 3) {

			System.out.print(" İban :");
			String iban = sc.nextLine();

			System.out.print(" Şifre : ");
			String password = sc.nextLine();

			Hesap aktifHesap = banka.login(iban, password);

			if (aktifHesap != null) {
				System.out.println("Giris basarılı.");
				islem_menusu(aktifHesap);
				break;

			} else {
				System.out.println("Giris basarısız lütfen tekrar deneyiniz.");
				deneme++;
			}
			if (deneme == 3) {
				System.out.println("Çok fazla deneme nedeniyle sistemden gecici olarak engellendiniz.");
				return;

			}

		}

	}

	public static void hesap_olustur() {

		while (true) {

			System.out.print(" Lütfen kullanmak istediginiz İbanı tuslayınız : ");
			String iban = sc.nextLine();

			System.out.print(" Sifre giriniz : ");
			String sifre = sc.nextLine();

			if (banka.iban_kontrol(iban)) {
				System.out.println("Böyle bi iban vardır ");
				
			}
			else {
				Hesap hesap = new Hesap(iban, sifre);
				banka.hesap_ekle(hesap);
				System.out.println("Hesap olusturuldu.");
				break;
				
				
			}
		
			
   
		

		}

	}

	public static void islem_menusu(Hesap aktif_hesap) {

		while (true) {

			System.out.println("\n--- İŞLEM MENÜ ---");
			System.out.println("1- Para Yatır");
			System.out.println("2- Para Çek");
			System.out.println("3- Transfer Yap");
			System.out.println("4- İşlem Geçmişi");
			System.out.println("5-Bakiye görüntüle");
			System.out.println("0- Çıkış Yap");

			int secim = guvenli_int("Secim : ");

			switch (secim) {

			case 1:
				int yatırılck_tutar = guvenli_int("Lütfen yatırılcak tutarı giriniz : ");
				try {
					aktif_hesap.para_yatir(yatırılck_tutar);

				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					System.out.println("İslem basasrısız tekrar deneyin");
					break;

				}
				System.out.println("-------");

				System.out.println("Hesabınıza " + yatırılck_tutar + "TL basasrıyla eklenmistir.");
				System.out.println("Güncel bakiye : " + aktif_hesap.getBakiye() + "TL");
				System.out.println("-------");
				break;

			case 2:
				int cekilecek_tutar = guvenli_int("Lütfen cekilecek tutarı giriniz : ");

				try {
					aktif_hesap.para_cek(cekilecek_tutar);

				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					System.out.println("İslem basarısız tekrar deneyin");
					break;
					
					
					

				}
				System.out.println("-------");
				System.out.println("Hesabınızdan " + cekilecek_tutar + "TL basarıyla cekilmistir.");
				System.out.println("Güncel bakiye : " + aktif_hesap.getBakiye() + "TL");
				System.out.println("-------");
				break;

			case 3:
				System.out.println("Lütfen alıcı ibanını giriniz :");
				String hedef_iban = sc.nextLine();

				Hesap hedefhesap = banka.hesap_bul(hedef_iban);

				if (hedefhesap != null) {
					int tutar = guvenli_int(" Lütfen göndermek istediginiz tutarı giriniz : ");

					try {
						aktif_hesap.Transfer(hedefhesap, tutar);

					} catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
						System.out.println("İslem basarısız daha sonra tekrar deneyiniz.");
						break;
					}

					System.out.println(tutar + "TL basarıyla " + hedef_iban + " ibanına gönderilmistir.");

				} else {
					System.out.println("Hesap bulunamadı!");
					System.out.println("Lütfen daha sonra tekrar deneyiniz.");
				}
				break;

			case 4:
				aktif_hesap.islem_yazdir();
				break;

			case 5:
				System.out.println("Güncel bakiye : " + aktif_hesap.getBakiye() + "TL");
				break;

			case 0:
				System.out.println("Çıkıs yapıldı.");
				return;

			}

		}

	}

}
