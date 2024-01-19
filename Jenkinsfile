@Library('msb-library@master')_
my_node = k8sagent(name: 'maven3.8.6')
podTemplate(my_node) {
  node(my_node.label) {
    env.PROJECT_NAME = "ibs-corp"
    env.SERVICE_NAME = "ibs-common"
    ibs_common_lib()
  }
}