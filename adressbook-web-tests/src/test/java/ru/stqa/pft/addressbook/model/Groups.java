package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;
import org.openqa.selenium.devtools.v85.dom.model.PseudoType;

import java.util.HashSet;
import java.util.Set;

public class Groups extends ForwardingSet<GroupData> {

private Set<GroupData> delegate;

    public Groups(Groups groups) {
    this.delegate = new HashSet<>(groups.delegate);
    }

    public Groups() {
        this.delegate = new HashSet<GroupData>();
    }

    @Override
    protected Set<GroupData> delegate() {
        return delegate;
    }

    public Groups withAdded (GroupData group) {
    Groups groups = new Groups(this);
    groups.add(group);
        return groups;
    }
    public Groups withOut (GroupData group) {
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }
}