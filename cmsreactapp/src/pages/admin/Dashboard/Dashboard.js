import React from 'react'
import Header from '../../../components/admin/common/Header'
import { Box, Typography, useTheme, Button, Grid } from "@mui/material";
import MenuList from '../../../components/admin/Dashboard/MenuList';
import StudentData from '../../../components/admin/Dashboard/StudentData';
import PendingOrders from '../../../components/admin/Dashboard/PendingOrders'
import PendingOrderTable from '../orderPages/PendingOrderTable';
export default function Dashboard() {
  return (
    <Box m="20px">
        <Header title = "Dashboard" subtitle = "Welcome to your dashboard"></Header>
        <Grid container>
          <Grid item xs={12} sm={6}>
            <StudentData></StudentData>
          </Grid>
          <Grid item xs={12} sm={6}>
            <div><MenuList></MenuList></div>
            
          </Grid>
          <Grid item xs={12} sm={12} marginTop={5}>
            <div><PendingOrders></PendingOrders></div>
          </Grid>
          {/* <Grid item xs={12} sm={6} marginTop={5}>
            <div><PendingOrderTable></PendingOrderTable></div>
          </Grid> */}

        </Grid>
    </Box>
  ) 
}
