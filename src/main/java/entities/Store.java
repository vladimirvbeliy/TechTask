package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="store_name")
    private String storeName;

    @OneToMany(mappedBy="store",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Category> categories;


    public Store() {
    }

    public Store(String storeName) {
        this.storeName = storeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }



    @Override
    public String toString() {
        return "MusicStore{" +
                "id=" + id +
                ", storeName='" + storeName + '\'' +
                '}';
    }
}
