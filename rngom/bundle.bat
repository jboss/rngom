call mvn -up clean source:jar javadoc:jar package gpg:sign repository:bundle-create -Dgpg.passphrase=%1