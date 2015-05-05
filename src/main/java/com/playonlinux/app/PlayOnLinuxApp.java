package com.playonlinux.app;

import com.playonlinux.api.Controller;
import com.playonlinux.injection.Component;
import com.playonlinux.injection.Inject;
import com.playonlinux.injection.InjectionException;
import com.playonlinux.domain.CancelException;
import com.playonlinux.domain.PlayOnLinuxError;

import java.io.IOException;

@Component
public class PlayOnLinuxApp {

    @Inject
    static PlayOnLinuxBackgroundServicesManager playOnLinuxBackgroundServicesManager;

    @Inject
    static Controller controller;

    public void start() throws PlayOnLinuxError, IOException,
            InjectionException {
        PlayOnLinuxConfig playOnLinuxConfig = new PlayOnLinuxConfig();
        playOnLinuxConfig.load();

        controller.startApplication();
    }

    public static void main(String [] args) throws CancelException, InterruptedException,
            PlayOnLinuxError, IOException, InjectionException {
        PlayOnLinuxApp application =  new PlayOnLinuxApp();
        application.start();

        playOnLinuxBackgroundServicesManager.shutdown();
    }

}