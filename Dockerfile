FROM ubuntu:18.04
ENV LANG=C.UTF-8 LC_ALL=C.UTF-8
ENV JAVA_HOME /usr/lib/jvm/java-11-oracle
RUN echo oracle-java11-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
    apt-get update && \
    apt-get install -y software-properties-common && \
    add-apt-repository -y ppa:webupd11team/java && \
    apt-get install --reinstall ca-certificates && \
    add-apt-repository ppa:ppaname/ppa && \
    apt-get update && \
    apt-get install -y oracle-java11-installer
#RUN apt-get update && apt-get install -y default-jdk tar && \
#    apt-get update && \
#    wget -y https://download.java.net/java/GA/jdk11/28/GPL/openjdk-11+28_linux-x64_bin.tar.gz -O /tmp/openjdk-11+28_linux-x64_bin.tar.gz && \
#    tar xfvz /tmp/openjdk-11+28_linux-x64_bin.tar.gz --directory /usr/lib/jvm && \
#    rm -f /tmp/openjdk-11+28_linux-x64_bin.tar.gz && \
#    /usr/lib/jvm/jdk-11/bin/java -version
#RUN apt-get update
#RUN apt-get install -y software-properties-common
#RUN apt-get update
#RUN add-apt-repository -y ppa:linuxuprising/java && \
#  echo oracle-java11-installer shared/accepted-oracle-license-v1-2 select true |  /usr/bin/debconf-set-selections && \
#  apt-get update && \
#  apt install -y oracle-java11-installer && \
#  mkdir /report6 && \
#  apt-get install -y maven && \
#  apt install oracle-java11-set-default
WORKDIR /report6
COPY . /report6/
