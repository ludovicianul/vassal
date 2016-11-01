FROM ubuntu:xenial

MAINTAINER Madalin Ilie <madalin.ilie@endava.com>

# Set the locale
RUN locale-gen en_GB.UTF-8
ENV LANG en_GB.UTF-8
ENV LANGUAGE en_GB:en
ENV LC_ALL en_GB.UTF-8

# copy Dockerfile to image
COPY Dockerfile /

RUN apt-get update && apt-get install -y software-properties-common

# Add Java 8 repository
RUN echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
    add-apt-repository -y ppa:webupd8team/java

# Install the stuff we need
RUN apt-get update && apt-get install -y \
    oracle-java8-installer \
    libxext-dev \
    libxrender-dev \
    libxtst-dev \
 && rm -rf /var/lib/apt/lists/* \
 && rm -rf /var/cache/oracle-jdk8-installer \
 && rm -rf /var/cache/apt

ENV JAVA_HOME /usr/lib/jvm/java-8-oracle


RUN adduser --quiet vassal
RUN echo "vassal:vassal" | chpasswd

RUN mkdir -p /home/vassal/app
COPY vassal-1.0.jar /home/vassal/app/vassal-1.0.jar

EXPOSE 12345

WORKDIR /home/vassal/app/

CMD ["java","-jar","vassal-1.0.jar","12345"]