package com.taegeun;

public enum GameSignal {
    RESTART(1);
    int signal;
    GameSignal(int signal) {
        this.signal = signal;
    }

    public int getSignal() {
        return signal;
    }
}
