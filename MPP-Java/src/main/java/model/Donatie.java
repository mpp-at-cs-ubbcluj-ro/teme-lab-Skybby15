package model;

public class Donatie extends Entity<Long> {
    private Donator donator;
    private CazCaritabil cazCaritabil;
    private Long sum;

    public Donatie(Long id,Donator donator, CazCaritabil cazCaritabil, Long suma) {
        super(id);
        this.donator = donator;
        this.cazCaritabil = cazCaritabil;
        this.sum = suma;

    }

    public Donator getDonator() {
        return donator;
    }

    public CazCaritabil getCazCaritabil() {
        return cazCaritabil;
    }

    public Long getSum() {
        return sum;
    }

    public void setCazCaritabil(CazCaritabil cazCaritabil) {
        this.cazCaritabil = cazCaritabil;
    }

    public void setDonator(Donator donator) {
        this.donator = donator;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }
}
