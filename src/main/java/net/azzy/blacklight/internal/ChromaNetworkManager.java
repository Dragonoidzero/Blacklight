package net.azzy.blacklight.internal;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.PersistentState;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

public class ChromaNetworkManager extends PersistentState {

    private final HashMap<UUID, ChromaNetwork> managedNetworks = new HashMap<>();

    public ChromaNetwork getNetwork(UUID id) {
        return managedNetworks.get(id);
    }

    public boolean contains(UUID id) {
        return managedNetworks.containsKey(id);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        int networks;
        UUID[] IDs = managedNetworks.keySet().toArray(new UUID[0]);
        for (networks = 0; networks < managedNetworks.size(); networks++) {
            UUID id = IDs[networks];
            tag.putUuid("id_" + networks, id);
            tag.put(id.toString(), managedNetworks.get(id).toTag());
        }
        tag.putInt("networks", networks);
        return tag;
    }

    @Override
    public void save(File file) {
        super.save(file);
    }

    public static ChromaNetworkManager load(CompoundTag tag) {

    }
}
