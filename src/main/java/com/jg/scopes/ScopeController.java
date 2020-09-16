package com.jg.scopes;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ScopeController {

    private final ScopeObject defaultBean;
    private final ScopeObject singletonBean;
    private final ScopeObject singletonBean2;
    private final ScopeObject prototypeBean;
    private final ScopeObject prototypeBean2;
    private final ScopeObject refreshBean;
    private final ScopeObject refreshBean2;

    public ScopeController(@Qualifier("defaultBean") final ScopeObject defaultBean,
                           @Qualifier("singletonBean") final ScopeObject singletonBean,
                           @Qualifier("singletonBean") final ScopeObject singletonBean2,
                           @Qualifier("prototypeBean") final ScopeObject prototypeBean,
                           @Qualifier("prototypeBean") final ScopeObject prototypeBean2,
                           @Qualifier("refreshBean") final ScopeObject refreshBean,
                           @Qualifier("refreshBean") final ScopeObject refreshBean2) {
        this.defaultBean = defaultBean;
        this.singletonBean = singletonBean;
        this.singletonBean2 = singletonBean2;
        this.prototypeBean = prototypeBean;
        this.prototypeBean2 = prototypeBean2;
        this.refreshBean = refreshBean;
        this.refreshBean2 = refreshBean2;
    }

    @GetMapping("/beans")
    public List<String> getBeans() {
        final List<String> beans = new ArrayList<>();
        beans.add("defaultBean - " + defaultBean.getId());
        beans.add("singletonBean - " + singletonBean.getId());
        beans.add("singletonBean2 - " + singletonBean2.getId());
        beans.add("prototypeBean - " + prototypeBean.getId());
        beans.add("prototypeBean2 - " + prototypeBean2.getId());
        beans.add("refreshBean - " + refreshBean.getId());
        beans.add("refreshBean2 - " + refreshBean2.getId());
        return beans;
    }
}
