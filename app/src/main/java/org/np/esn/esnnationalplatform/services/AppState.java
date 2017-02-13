package org.np.esn.esnnationalplatform.services;

import org.np.esn.esnnationalplatform.model.Member;
import org.np.esn.esnnationalplatform.model.NationalPlatformInfo;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppState {

    private NationalPlatformInfo nationalPlatformInfo;

    @Inject
    public AppState() {
    }

    public NationalPlatformInfo getNationalPlatformInfo(){

        if (nationalPlatformInfo == null) {
            //TODO read file and put in this object.
            nationalPlatformInfo = new NationalPlatformInfo();
            ArrayList<Member> members = new ArrayList<>(3);
            members.add(new Member("test1F", "test1", "http://lorempixel.com/g/400/400/"));
            members.add(new Member("test2F", "test2", "http://lorempixel.com/g/400/400/"));
            members.add(new Member("test3F", "test3", "http://lorempixel.com/g/400/400/"));
            members.add(new Member("test4F", "test4", "http://lorempixel.com/g/400/400/"));
            members.add(new Member("test5F", "test5", "http://lorempixel.com/g/400/400/"));
            nationalPlatformInfo.setMembers(members);
        }

        return nationalPlatformInfo;
    }
}
