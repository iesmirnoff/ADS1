package org.example;

public class BloomFilter
{
    public int filter_len;

    private int byteArray = 0;

    public BloomFilter(int f_len)
    {
        filter_len = f_len;
    }


    public int hash1(String str1)
    {
        // 17
        int result = 0;
        for(int i=1; i<str1.length(); i++)
        {
            int code = (int)str1.charAt(i);
            result = (result * 17 + code) % ((int)Math.pow(2, filter_len-1));
        }
        return result;
    }

    public int hash2(String str1)
    {
        int result = 0;
        for(int i=1; i<str1.length(); i++)
        {
            int code = (int)str1.charAt(i);
            result = (result * 223 + code) % ((int)Math.pow(2, filter_len-1));
        }
        return result;
    }

    public void add(String str1)
    {
        int hash1 = hash1(str1);
        int hash2 = hash2(str1);
        byteArray |= hash1;
        byteArray |= hash2;
    }

    public boolean isValue(String str1)
    {
        int hash1 = hash1(str1);
        int hash2 = hash2(str1);

        return (hash1 ^ byteArray & hash1) == 0 && (hash2 ^ byteArray & hash2) == 0;
    }
}