package product;

public class Urun {

    private int urunNo;
    private String urunAd;
    private String urunCins;
    private double urunFiyat;
    private int urunMiktar;

    public String getUrunTur() {
        return urunTur;
    }

    public void setUrunTur(String urunTur) {
        this.urunTur = urunTur;
    }

    private String urunTur;

    public Urun() {
    }

    public Urun(int urunNo, String urunAd, String urunCins, int urunFiyat, int urunMiktar) {
        this.urunNo = urunNo;
        this.urunAd = urunAd;
        this.urunCins = urunCins;
        this.urunFiyat = urunFiyat;
        this.urunMiktar = urunMiktar;
    }

    public Urun(int urunNo, String urunAd, String urunCins, double urunFiyat, int urunMiktar, String urunTur) {
        this.urunNo = urunNo;
        this.urunAd = urunAd;
        this.urunCins = urunCins;
        this.urunFiyat = urunFiyat;
        this.urunMiktar = urunMiktar;
        this.urunTur = urunTur;
    }

    public int getUrunNo() {
        return urunNo;
    }

    public void setUrunNo(int urunNo) {
        this.urunNo = urunNo;
    }

    public String getUrunAd() {
        return urunAd;
    }

    public void setUrunAd(String urunAd) {
        this.urunAd = urunAd;
    }

    public String getUrunCins() {
        return urunCins;
    }

    public void setUrunCins(String urunCins) {
        this.urunCins = urunCins;
    }

    public double getUrunFiyat() {
        return urunFiyat;
    }

    public void setUrunFiyat(double urunFiyat) {
        this.urunFiyat = urunFiyat;
    }

    public int getUrunMiktar() {
        return urunMiktar;
    }

    public void setUrunMiktar(int urunMiktar) {
        this.urunMiktar = urunMiktar;
    }
}
