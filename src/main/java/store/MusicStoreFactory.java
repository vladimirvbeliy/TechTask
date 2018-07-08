package store;

public class MusicStoreFactory extends StoreFactory {
    @Override
    public StoreInterace buildStore() {
        return MusicStore.getInstance();
    }
}
