package io.xstefank;

import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;

@Version("v1beta1")
@Group("xstefank.io")
public class TestCustomResourc extends CustomResource<TestCustomResourcSpec, TestCustomResourcStatus> implements Namespaced { }