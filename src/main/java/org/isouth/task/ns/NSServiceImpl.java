package org.isouth.task.ns;

import org.isouth.task.NSService;
import org.isouth.task.user.UserEvent;
import org.isouth.task.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NSServiceImpl implements NSService {
    @Autowired
    private NSDao nsDao;

    @Autowired
    private UserService userService;

    public void init() {
        userService.observe().subscribe(e -> {
            if (UserEvent.ADD.equals(e.getType())) {
                addNS(new NS()
                    .setName(e.getUser()
                        .getName())
                    .setType(NS.USER_TYPE));
            } else {
            }
        });
    }

    @Override
    public NS addNS(NS ns) {
        nsDao.addNS(ns);
        return ns;
    }

    @Override
    public void deleteNS(String id) {

    }

    @Override
    public List<NS> listNSs() {
        return null;
    }
}
