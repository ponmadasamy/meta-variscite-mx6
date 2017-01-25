#@DESCRIPTION: Linux for Variscite i.MX6Q/D/DL/S VAR-SOM-MX6 family
#
# http://www.variscite.com
# support@variscite.com

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "imx-rel_imx_4.1.15_1.1.0_ga-var02"
LOCALVERSION = "-6QP"
#SRCREV = "${AUTOREV}"
SRCREV = "59c1cffddf6e774281a97661f9fc4e0a1ae394e0"
#KERNEL_SRC ?= "git://github.com/varigit/linux-2.6-imx.git;protocol=git"
KERNEL_SRC ?= "git://github.com/ponmadasamy/linux-2.6-imx.git;protocol=git"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH}"

FSL_KERNEL_DEFCONFIG = "imx_v7_var_defconfig"

KERNEL_IMAGETYPE = "uImage"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

do_configure_prepend() {
   # copy latest defconfig for imx_v7_var_defoonfig to use
   #cp ${S}/arch/arm/configs/imx_v7_var_defconfig ${B}/.config
   #cp ${S}/arch/arm/configs/imx_v7_var_defconfig ${B}/../defconfig
   cp ${S}/arch/arm/configs/imx_v7_var_drmc_defconfig ${B}/.config
   cp ${S}/arch/arm/configs/imx_v7_var_drmc_defconfig ${B}/../defconfig
}


# Copy the config file required by ti-compat-wirless-wl18xx
do_deploy_append () {
   #cp ${S}/arch/arm/configs/imx_v7_var_defconfig ${S}/.config
   cp ${S}/arch/arm/configs/imx_v7_var_drmc_defconfig ${S}/.config
}


COMPATIBLE_MACHINE = "(var-som-mx6)"

DEFAULT_PREFERENCE = "1"

