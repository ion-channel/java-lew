# -*- mode: ruby -*-
# vi: set ft=ruby :

# Vagrantfile API/syntax version. Don't touch unless you know what you're doing!
VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|

  if Vagrant.has_plugin?('landrush')
    config.landrush.enabled = true
    config.landrush.tld = 'dev'
    config.landrush.guest_redirect_dns = true
  end

  config.vm.define 'lew' do |base|
    base.vm.provider 'virtualbox' do |v|
      v.memory = 2048
      v.cpus = 2
    end
    base.vm.box = 'ubuntu/trusty64'
    base.vm.hostname = 'lew.vagrant.dev'
    base.vm.network 'private_network', type: 'dhcp'
  end

end
