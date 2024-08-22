<template>
  <div class="app-container">
    <el-form :model="productQuery" ref="productQueryForm" size="small" :inline="true" label-width="68px">
      <el-form-item label="商品名称" prop="commodity_name">
        <el-input
          v-model="productQuery.commodity_name"
          placeholder="请输入商品名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
      </el-form-item>
    </el-form>
    <el-table v-loading="loading" :data="list" style="width: 100%">
      <el-table-column label="序号" type="index" align="center">
        <template slot-scope="scope">
          <span>{{ (pageNum - 1) * pageSize + scope.$index + 1 }}</span>
        </template>
      </el-table-column>
      <el-table-column
        label="商品名称"
        align="center"
        prop="commodity_name"
        width="240"
        :show-overflow-tooltip="true"
      />
      <el-table-column label="商品价格" align="center" prop="commodity_price" />
      <el-table-column label="价格单位" align="center" prop="price_units" />
      <el-table-column label="商品图片" align="center" prop="commodity_image" :show-overflow-tooltip="true">
        <template slot-scope="scope"
          ><ImagePreview :src="scope.row.commodity_image" width="50px" height="50px"
        /></template>
      </el-table-column>
      <el-table-column label="商品负责人" align="center" prop="commodity_charger" width="120">
        <template slot-scope="scope">
          <el-button type="text" size="mini">{{ scope.row.commodity_charger }}</el-button>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="创建时间" align="center" prop="create_time" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.create_time) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="更新时间" align="center" prop="update_time" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.update_time) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="创建人" align="center" prop="create_by" width="120">
        <template slot-scope="scope">
          <span>{{ scope.row.create_by }}</span>
        </template>
      </el-table-column>
      <el-table-column label="更新人" align="center" prop="update_by" width="120">
        <template slot-scope="scope">
          <span>{{ scope.row.update_by }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" width="180" :show-overflow-tooltip="true" />
    </el-table>

    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="pageNum"
      :limit.sync="pageSize"
      @pagination="changePager"
    />
  </div>
</template>

<script>
import { getProductList } from '@/api/product'

export default {
  name: 'ProductManage',
  data() {
    return {
      // 遮罩层
      loading: false,
      // 总条数
      total: 0,
      // 表格数据
      list: [],
      pageNum: 1,
      pageSize: 10,
      // 查询参数
      productQuery: {
        commodity_name: undefined,
      },
    }
  },
  created() {
    this.getProductList()
  },
  methods: {
    /**
     * 获取商品列表
     * @param query 查询参数
     */
    async getProductList(query = {}) {
      this.loading = true
      try {
        const { data, code } = await getProductList(query)
        if (code === 200 && data) {
          const { total, items } = data
          this.list = items
          this.total = total
        }
      } catch (err) {
        this.$modal.msgError('获取商品列表错误!')
      }
      this.loading = false
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.pageNum = 1
      this.getProductList({
        pageNum: this.pageNum,
        pageSize: this.pageSize,
        ...this.productQuery,
      })
    },
    changePager({ page, limit }) {
      this.pageNum = page
      this.pageSize = limit
      this.getProductList({
        pageNum: this.pageNum,
        pageSize: this.pageSize,
        ...this.productQuery,
      })
    },
  },
}
</script>
