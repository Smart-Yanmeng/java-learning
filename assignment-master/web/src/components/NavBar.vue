<template>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <!-- bg-body-tertiary 白色导航栏 -->
        <div class="container">
            <router-link class="navbar-brand" :to="{ name: 'home' }" active-class="active">患者信息管理系统</router-link>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/home/">首页</a>
                    </li>
                    <li class="nav-item">
                        <router-link class="nav-link" :to="{ name: 'info_index' }" active-class="active">患者信息</router-link>
                    </li>
                    <li class=" nav-item">
                        <router-link class="nav-link" :to="{ name: 'require_index' }"
                            active-class="active">查询中心</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link class="nav-link" :to="{ name: 'chat_index' }" active-class="active">聊天</router-link>
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            aer
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <router-link class="dropdown-item" :to="{ name: 'admin_info_index' }"
                                    active-class="active">个人中心</router-link>
                            </li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="#">退出登录</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</template>

<script>
</script>

<style scoped></style>