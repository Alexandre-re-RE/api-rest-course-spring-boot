node {
	    // reference to maven
	    // ** NOTE: This 'maven-3.5.2' Maven tool must be configured in the Jenkins Global Configuration.   
	    def mvnHome = tool 'MAVEN_3.9.6'
	    
	    stage('Clone Repo') { // for display purposes
	      // Get some code from a GitHub repository
	      git 'https://github.com/Alexandre-re-RE/api-rest-course-spring-boot.git'
	      // Get the Maven tool.
	      // ** NOTE: This 'maven-3.5.2' Maven tool must be configured
	      // **       in the global configuration.           
	      mvnHome = tool 'MAVEN_3.9.6'
	    }    
	  
	    stage('Build Project') {
	      // build project via maven
	      sh "'${mvnHome}/bin/mvn' clean install"
	    }
			
	    stage('Deploy') {
	      sshPublisher(publishers: [sshPublisherDesc(configName: 'APU-SPRING', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: 'echo "hi"', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/home/', remoteDirectorySDF: false, removePrefix: '', sourceFiles: 'target/api-rest-course-spring-boot-0.0.1-SNAPSHOT.jar')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
	    }

	}
