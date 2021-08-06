package com.apratim.finance;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.apratim.finance");

        noClasses()
            .that()
            .resideInAnyPackage("com.apratim.finance.service..")
            .or()
            .resideInAnyPackage("com.apratim.finance.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.apratim.finance.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
