import java.util.ArrayList;

import java.util.List;

public class Hesap {

	private final String iban;
	private String password;
	private double bakiye;
	private final List<İslem> islemler = new ArrayList<>();

	public double getBakiye() {
		return bakiye;
	}

	public String getIban() {
		return iban;
	}

	public Hesap(String iban, String password) {

		this.iban = iban;
		this.password = password;
		this.bakiye = 0; 
	}

	public void para_yatir(double miktar) throws IllegalArgumentException {

		if (miktar <= 0) {

			throw new IllegalArgumentException("Miktar 0 dan büyük olmalı.");

		}

		bakiye += miktar;

		İslem yeni_islem = new İslem(İslemTuru.YATIRMA, miktar, "Hesabınıza " + miktar + "TL eklenmistir.");
		islemler.add(yeni_islem);

	}

	public void para_cek(double miktar) throws IllegalArgumentException {

		if (miktar <= 0) {

			throw new IllegalArgumentException("Miktar 0 dan büyük olmalı!");
		}

		if (miktar > bakiye) {
			throw new IllegalArgumentException("Bakiye yetersiz , güncel bakiye : " + bakiye);

		}

		bakiye -= miktar;

		İslem yeni_Islem = new İslem(İslemTuru.CEKME, miktar, "Hesabınızdan " + miktar + "TL  eksilmistir.");
		islemler.add(yeni_Islem);

	}

	public void Transfer(Hesap hedef, double miktar) throws IllegalArgumentException {

		if (hedef == null) {

			throw new IllegalArgumentException("Hedef hesap bos olamaz !");

		}

		if (this == hedef) {

			throw new IllegalArgumentException(" Kendi hesabına transfer yapamazsın :)");

		} 

		this.para_cek(miktar); 
		hedef.para_yatir(miktar); 
									
        İslem yeni_Islem = new İslem(İslemTuru.TRANSFER, miktar, iban);
        islemler.add(yeni_Islem);
	}

	public void islem_yazdir() {

		System.out.println(" === " + iban + " İşlem gecmisi ===");

		if (islemler.isEmpty()) {

			System.out.println("Henüz islem yok.");
			return;

		}
		

		for (İslem islem : islemler) { 
			System.out.println(islem);
			System.out.println("--------");

		}

	}

	public boolean sifre_kontrol(String girilen_sifre) {

		if (girilen_sifre.equals(password)) {
			return true;

		} else {
			return false;
		}

	}

	@Override
	public String toString() {
		return "İban : " + iban + "  |||  Bakiye : " + bakiye + "TL";

	}

}
