package store;

public class SportStoreFactory extends StoreFactory {
    @Override
    public StoreInterace buildStore() {
        return SportsStore.getInstance();
    }
}
