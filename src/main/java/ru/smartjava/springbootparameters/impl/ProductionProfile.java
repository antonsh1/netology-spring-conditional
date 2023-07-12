package ru.smartjava.springbootparameters.impl;

import ru.smartjava.springbootparameters.interfaces.SystemProfile;

public class ProductionProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}
