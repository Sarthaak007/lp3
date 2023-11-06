// Problem Statement : 
// - Develop a Blockchain based application for transparent and genuine charity 
// Name : Kapil Soni
// Roll no. : B-50



// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract Charity {
    address public admin;
    mapping(address => uint256) public donations;
    uint256 public totalDonations;

    event DonationReceived(address indexed donor, uint256 amount);
    event FundsWithdrawn(address indexed admin, uint256 amount);

    modifier onlyAdmin() {
        require(msg.sender == admin, "Only admin can perform this action");
        _;
    }

    constructor() {
        admin = msg.sender;
    }

    function donate(uint256 value) external payable {
        require(value > 0, "Donation amount must be greater than 0");
        donations[msg.sender] += value;
        totalDonations += value;
        emit DonationReceived(msg.sender, value);
    }

    function withdrawFunds(uint256 _amount) public onlyAdmin {
        require(_amount <= address(this).balance, "Insufficient funds");
        payable(admin).transfer(_amount);
        emit FundsWithdrawn(admin, _amount);
    }
}
