package com.sqide.runner;

import com.sqide.SquirrelIcons;
import com.sqide.util.SquirrelInterpreterDetection;
import com.intellij.execution.BeforeRunTask;
import com.intellij.execution.RunManagerEx;
import com.intellij.execution.configuration.ConfigurationFactoryEx;
import com.intellij.execution.configurations.ConfigurationTypeBase;
import com.intellij.execution.configurations.ConfigurationTypeUtil;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RunConfigurationModule;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;

/**
 * Squirrel run configuration type.
 *
 * @author jansorg
 */
public class SquirrelConfigurationType extends ConfigurationTypeBase {
    public SquirrelConfigurationType() {
        super("SquirrelConfigurationType", "Squirrel", "Squirrel run configuration", SquirrelIcons.NUT_FILE);

        addFactory(new SquirrelConfigurationFactory(this));
    }

    @NotNull
    public static SquirrelConfigurationType getInstance() {
        return ConfigurationTypeUtil.findConfigurationType(SquirrelConfigurationType.class);
    }

    private static class SquirrelConfigurationFactory extends ConfigurationFactoryEx {
        public SquirrelConfigurationFactory(SquirrelConfigurationType configurationType) {
            super(configurationType);
        }

        @Override
        public void onNewConfigurationCreated(@NotNull RunConfiguration configuration) {
            //the last param has to be false because we do not want a fallback to the template (we're creating it right now) (avoiding a SOE)
            RunManagerEx.getInstanceEx(configuration.getProject()).setBeforeRunTasks(configuration, Collections.<BeforeRunTask>emptyList(), false);
        }

        @Override
        public RunConfiguration createTemplateConfiguration(Project project) {
            SquirrelRunConfiguration configuration = new SquirrelRunConfiguration(new RunConfigurationModule(project), this, "");
            configuration.setInterpreterPath(SquirrelInterpreterDetection.instance().findBestLocation());

            return configuration;
        }
    }
}
