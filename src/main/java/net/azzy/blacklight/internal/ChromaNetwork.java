package net.azzy.blacklight.internal;

import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import net.azzy.blacklight.BlacklightInit;
import net.azzy.blacklight.api.ChromaticActor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;

import java.io.*;

public class ChromaNetwork {

    private final Long2ObjectOpenHashMap<ChromaticActor> networkActors;

    public ChromaNetwork() {
        networkActors = new Long2ObjectOpenHashMap<>();
    }

    private ChromaNetwork(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteIn = new ByteArrayInputStream(bytes);
        networkActors = (Long2ObjectOpenHashMap<ChromaticActor>) new ObjectInputStream(byteIn).readObject();
    }

    public Tag toTag() {
        CompoundTag tag = new CompoundTag();
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        try {
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(networkActors);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tag.putByteArray("network_data", byteOut.toByteArray());
        return tag;
    }

    public static ChromaNetwork fromTag(CompoundTag tag) {
        if(tag.contains("network_data")) {
            try {
                return new ChromaNetwork(tag.getByteArray("network_data"));
            } catch (IOException | ClassNotFoundException e) {
                BlacklightInit.BLACKLIGHT_LOG.error("Error while loading Chroma Network", e);
            }
        }
        return new ChromaNetwork();
    }
}
