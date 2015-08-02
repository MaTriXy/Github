package com.github.florent37.github;

import com.github.florent37.github.dagger.DaggerGithubComponent;
import com.github.florent37.github.dagger.GithubComponent;
import com.github.florent37.github.dagger.ContextModule;

/**
 * Created by florentchampigny on 03/06/15.
 */
public class Application extends android.app.Application {

    private static Application application;
    private GithubComponent githubComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Application.application = this;

        this.githubComponent = DaggerGithubComponent.builder()
                .contextModule(ContextModule.with(this))
                .build();
    }

    public static Application app() {
        return application;
    }

    public GithubComponent component() {
        return githubComponent;
    }

}