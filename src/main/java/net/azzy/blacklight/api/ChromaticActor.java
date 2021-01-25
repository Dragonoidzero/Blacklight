package net.azzy.blacklight.api;

public interface ChromaticActor {

    default ChromaActorType getActorType() {
        return ChromaActorType.DELETED;
    }


}
