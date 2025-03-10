package model;

public class CazCaritabil extends Entity<Long>{
    private String name;

    public CazCaritabil(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
