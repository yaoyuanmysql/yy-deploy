#!/usr/bin/env bash
# 需要打包的目录
_packageUrl=$1

function package() {

    cd ${_packageUrl}
    mvn package -Dmaven.test.skip=true
}

package
