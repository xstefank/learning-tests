package io.xstefank;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.javaoperatorsdk.operator.api.reconciler.Context;
import io.javaoperatorsdk.operator.api.reconciler.Reconciler;
import io.javaoperatorsdk.operator.api.reconciler.UpdateControl;

public class TestCustomResourcReconciler implements Reconciler<TestCustomResourc> {
    @Override
    public UpdateControl<TestCustomResourc> reconcile(TestCustomResourc resource, Context<TestCustomResourc> context) {
        return UpdateControl.noUpdate();
    }
}