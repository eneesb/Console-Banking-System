
import java.time.LocalDateTime;

public class İslem {

	private final İslemTuru islem;
	private final double miktar;
	private final LocalDateTime tarih;
	private final String aciklama;

	public İslem(İslemTuru islem, double miktar, String aciklama) {

		this.islem = islem;
		this.miktar = miktar;
		this.tarih = LocalDateTime.now();
		this.aciklama = aciklama;
	}

	public İslemTuru getIslem() {
		return islem;
	}

	public double getMiktar() {
		return miktar;
	}

	public LocalDateTime getTarih() {
		return tarih;
	}

	public String getAciklama() {
		return aciklama;
	}

	@Override
	public String toString() {
		return " İŞLEM  :" + islem + " ||  MİKTAR :  " + miktar + "TL" + " ||  TARİH : " + tarih + " ||  AÇIKLAMA :"
				+ aciklama;
	}

}
