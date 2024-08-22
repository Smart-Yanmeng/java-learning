export const AdminRoutes = [
  {
    path: "/",
    component: "Layout",
    meta: { title: "商品管理" },
    redirect: "/admin/productManage",
    children: [
      {
        path: "admin/productManage",
        name: "ProductManage",
        component: "admin/product/ProductManage",
        meta: { title: "商品管理", elIcon: "el-icon-s-order" },
      },
    ],
  },
]
