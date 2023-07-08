package com.controllers;

import com.managers.SceneManager;

public class BaseController {
    protected SceneManager sceneManager;
    public void setSceneManager(SceneManager sceneManager) { // if SceneManager and BaseController are in different packages, change visibility
        this.sceneManager = sceneManager;
    }
}
